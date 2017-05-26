package com.teleop_drone.org;

import android.app.Activity;
import android.os.Bundle;

import org.ros.android.MessageCallable;
import org.ros.android.RosActivity;
import org.ros.android.view.RosTextView;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMainExecutor;


import java.net.URI;


public class MainActivity extends Activity
{
    private RosTextView<std_msgs.String> rosTextView;
    public MainActivity(){
//        super("my_first_app", "my_first_app");
    }
    /** Called when the activity is first created. */
    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rosTextView = (RosTextView<std_msgs.String>)findViewById(R.id.text);
        rosTextView.setTopicName("chatter");
        rosTextView.setMessageType(std_msgs.String._TYPE);
        rosTextView.setMessageToStringCallable(new MessageCallable<String, std_msgs.String>() {
            @Override
            public String call(std_msgs.String message) {
                return message.getData();
            }
        });
    }
/*    @Override
    protected void init(NodeMainExecutor nodeMainExecutor){
    //    NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        //nodeConfiguration.setMasterUri(URI.create("http://192.168.43.226:11311"));
      //  nodeConfiguration.setMasterUri(getMasterUri());
       // nodeMainExecutor.execute(rosTextView, nodeConfiguration);
    }*/
}
