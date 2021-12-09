package b4a.example;

import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
		BA.handler.postDelayed(new WaitForLayout(), 5);

	}
	private static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
		return true;
	}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true)
				return true;
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
		this.setIntent(intent);
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public mysql.mysqlhandler _mh1 = null;
public mysql.mysqlhandler.ResultSetWrapper _rs1 = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv1 = null;
public anywheresoftware.b4a.objects.ListViewWrapper _lv1 = null;
public anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hsv1 = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
		Debug.PushSubsStack("Activity_Create (main) ","main",0,mostCurrent.activityBA,mostCurrent);
try {
anywheresoftware.b4a.objects.LabelWrapper _l = null;
int _i = 0;
int _j = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 31;BA.debugLine="mh1.Initialize(\"10.0.0.10:3306\",\"dbase\",\"hobert\",\"starks\")";
Debug.ShouldStop(1073741824);
mostCurrent._mh1.Initialize("10.0.0.10:3306","dbase","hobert","starks");
 BA.debugLineNum = 34;BA.debugLine="If mh1.isConnected = False Then";
Debug.ShouldStop(2);
if (mostCurrent._mh1.isConnected==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 35;BA.debugLine="Msgbox(mh1.SQLError, \"Connection Error:\")";
Debug.ShouldStop(4);
anywheresoftware.b4a.keywords.Common.Msgbox(mostCurrent._mh1.SQLError,"Connection Error:",mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return "";
 };
 BA.debugLineNum = 39;BA.debugLine="rs1 = mh1.Query(\"SELECT * FROM tbluser\")";
Debug.ShouldStop(64);
mostCurrent._rs1.setObject((java.sql.ResultSet)(mostCurrent._mh1.Query("SELECT * FROM tbluser")));
 BA.debugLineNum = 40;BA.debugLine="If rs1.IsInitialized = False Then";
Debug.ShouldStop(128);
if (mostCurrent._rs1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 BA.debugLineNum = 41;BA.debugLine="Msgbox(\"ResultSet is empty\" & CRLF & mh1.SQLError, \"Warning\")";
Debug.ShouldStop(256);
anywheresoftware.b4a.keywords.Common.Msgbox("ResultSet is empty"+anywheresoftware.b4a.keywords.Common.CRLF+mostCurrent._mh1.SQLError,"Warning",mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="Return";
Debug.ShouldStop(512);
if (true) return "";
 };
 BA.debugLineNum = 45;BA.debugLine="hsv1.Initialize(rs1.ColumnCount * 150dip,0)";
Debug.ShouldStop(4096);
mostCurrent._hsv1.Initialize(mostCurrent.activityBA,(int)(mostCurrent._rs1.ColumnCount()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(150))),BA.NumberToString(0));
 BA.debugLineNum = 46;BA.debugLine="Activity.AddView(hsv1,0,0,100%x,100%y)";
Debug.ShouldStop(8192);
mostCurrent._activity.AddView((android.view.View)(mostCurrent._hsv1.getObject()),(int)(0),(int)(0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float)(100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float)(100),mostCurrent.activityBA));
 BA.debugLineNum = 48;BA.debugLine="sv1.Initialize(rs1.RowCount * 30dip)";
Debug.ShouldStop(32768);
mostCurrent._sv1.Initialize(mostCurrent.activityBA,(int)(mostCurrent._rs1.RowCount()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(30))));
 BA.debugLineNum = 49;BA.debugLine="hsv1.Panel.AddView(sv1,0,0,rs1.ColumnCount*150dip,100%y)";
Debug.ShouldStop(65536);
mostCurrent._hsv1.getPanel().AddView((android.view.View)(mostCurrent._sv1.getObject()),(int)(0),(int)(0),(int)(mostCurrent._rs1.ColumnCount()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(150))),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float)(100),mostCurrent.activityBA));
 BA.debugLineNum = 51;BA.debugLine="Dim l As Label";
Debug.ShouldStop(262144);
_l = new anywheresoftware.b4a.objects.LabelWrapper();Debug.locals.put("l", _l);
 BA.debugLineNum = 53;BA.debugLine="For i=0 To rs1.RowCount - 1";
Debug.ShouldStop(1048576);
{
final double step25 = 1;
final double limit25 = (int)(mostCurrent._rs1.RowCount()-1);
for (_i = (int)(0); (step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25); _i += step25) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 54;BA.debugLine="rs1.Position = i";
Debug.ShouldStop(2097152);
mostCurrent._rs1.setPosition(_i);
 BA.debugLineNum = 55;BA.debugLine="For j=0 To rs1.ColumnCount - 1";
Debug.ShouldStop(4194304);
{
final double step27 = 1;
final double limit27 = (int)(mostCurrent._rs1.ColumnCount()-1);
for (_j = (int)(0); (step27 > 0 && _j <= limit27) || (step27 < 0 && _j >= limit27); _j += step27) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 56;BA.debugLine="l.Initialize(\"label\" & j)";
Debug.ShouldStop(8388608);
_l.Initialize(mostCurrent.activityBA,"label"+BA.NumberToString(_j));
 BA.debugLineNum = 57;BA.debugLine="l.Text = rs1.GetString(j)";
Debug.ShouldStop(16777216);
_l.setText((Object)(mostCurrent._rs1.GetString(_j)));
 BA.debugLineNum = 58;BA.debugLine="l.TextColor = Colors.Black";
Debug.ShouldStop(33554432);
_l.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 BA.debugLineNum = 59;BA.debugLine="l.Color = Colors.White";
Debug.ShouldStop(67108864);
_l.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 BA.debugLineNum = 60;BA.debugLine="sv1.Panel.AddView(l,j*150dip,i*30dip,149dip,29dip)";
Debug.ShouldStop(134217728);
mostCurrent._sv1.getPanel().AddView((android.view.View)(_l.getObject()),(int)(_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(150))),(int)(_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(30))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(149)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int)(29)));
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 63;BA.debugLine="mh1.Close";
Debug.ShouldStop(1073741824);
mostCurrent._mh1.Close();
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return "";
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    if (mostCurrent != null && mostCurrent.activityBA != null) {
Debug.StartDebugging(mostCurrent.activityBA, 27668, new int[] {3}, "5b7501b3-87e5-4aa1-8b21-729ee8978651");}

    if (processGlobalsRun == false) {
	    processGlobalsRun = true;
		try {
		        main._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

public static void killProgram() {
    
            if (main.previousOne != null) {
				Activity a = main.previousOne.get();
				if (a != null)
					a.finish();
			}

}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim mh1 As MysqlHandler";
mostCurrent._mh1 = new mysql.mysqlhandler();
 //BA.debugLineNum = 20;BA.debugLine="Dim rs1 As ResultSet";
mostCurrent._rs1 = new mysql.mysqlhandler.ResultSetWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim sv1 As ScrollView";
mostCurrent._sv1 = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim lv1 As ListView";
mostCurrent._lv1 = new anywheresoftware.b4a.objects.ListViewWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim hsv1 As HorizontalScrollView";
mostCurrent._hsv1 = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
  public Object[] GetGlobals() {
		return new Object[] {"Activity",_activity,"mh1",_mh1,"rs1",_rs1,"sv1",_sv1,"lv1",_lv1,"hsv1",_hsv1};
}
}
