package com.example.eclipse_php;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button submit;
String frname="",lname="";
    String result,DbResponse = "";
    EditText firstname,lastname;

    TextView tv;
    byte[] data;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    InputStream inputStream;  
    List<NameValuePair> nameValuePairs;
    /** Called when the activity is first created. */
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
   StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//initialzing firstname and submit
        firstname = (EditText) findViewById(R.id.firstname);
        submit = (Button) findViewById(R.id.submit);
        TextView show=(TextView)findViewById(R.id.display);
        
        show.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(getApplication(),Activity2.class);
				startActivity(intent);
			}
		});

      //Adding a listener to the submit buuton
        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

          //On the click of the button capture the value from the edit text 
            frname = firstname.getText().toString();

              //Check of the edit text is blank
           
		        if(frname.equals("") )
		        {
		             Toast.makeText(getApplication(), "Blank Field..Please Enter", Toast.LENGTH_LONG).show();
		        }
		        else
		        {

		        	//If the Edit text is not blank call the method postDataToDB()
		        	postDataToDB();
		        			        }
		        	            }
		        	        }
		        	        );}
		        	        public void postDataToDB(){
		        	        try {
		        	        	httpclient = new DefaultHttpClient();
		        	
		        	//Acees the remote php file through the httppost
		        	            httppost = new HttpPost("http://(Enter your ip address)/Android/insert.php");
		        	            
		        	            //  initialize NameValuePair by indicating the number of values it should hold
		        	        List<NameValuePair> nameValuePairs= new ArrayList<NameValuePair>(1);
		        	
		        	 // Add/append your data to the NameValuePair
		        	           nameValuePairs.add(new BasicNameValuePair("first", 
		        	        		   frname.trim()));
		        	           
		        	            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));  
		        	
		        	            // Execute HTTP Post Request
		        	            response = httpclient.execute(httppost);
		        	
		        	//On executing (making a request) on the httppost we get a response which we store in the inputstream.
		        	
		        	            inputStream = response.getEntity().getContent();
		        	
		        	            //Declaring a byte array variable
		        	
		        	data = new byte[256];
		        	//intialzing buffer variable
		        	            buffer = new StringBuffer();
		        	            int len = 0;

		        	          //As long as there is data in the inputstream read data from the inputstream and store it on the data byte array, then append the data on a buffer
		        	            while (-1 != (len = inputStream.read(data)) )
		        	                        {
		        	                            buffer.append(new String(data, 0, len));
		        	                        }
		        	                        inputStream.close();
		        	            //Convert response to string
		        	                        result = buffer.toString();
		        	                    }
		        	                    catch (Exception e){
		        	                        Toast.makeText(getApplication(), "error"+e.toString(), Toast.LENGTH_LONG).show();
		        	                    }
		        	                    try {
		        	            			String jsonString = result;
		        	            			// Create a JSON object that we can use from the String
		        	            			JSONObject jObject = new JSONObject(jsonString);
		        	            			//Extract the response from the server and append it to a string.

		        	            			//The response determines what the app will do next
		        	            			DbResponse = jObject.getString("response");
		        	            		} catch (JSONException e1) {
		        	            			
		        	            		} catch (ParseException e1) {
		        	            			
		        	            		} catch (Exception e) {
		        	            			
		        	            		}
		        	                   if (DbResponse.equals("Y")) {
		        	                   	
		        	                	   Toast.makeText(getBaseContext(), "Registration Successful",Toast.LENGTH_SHORT).show();
		        	                	   firstname.setText("");
		        	            		} else{
		        	            			Toast.makeText(getBaseContext(), "Registration Failed",Toast.LENGTH_SHORT).show();
		        	            		}
		        	             }
		        	                }
		        	            
