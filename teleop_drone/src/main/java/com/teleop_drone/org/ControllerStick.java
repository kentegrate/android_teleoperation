package com.teleop_drone.org;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.animation.Animation;

import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeMain;


/**
 * Created by ken on 16/12/13.
 */

public class ControllerStick extends RelativeLayout implements Animation.AnimationListener, NodeMain
{
    private ImageView divet;
    private void initControllerStick(Context context){
        LayoutInflater.from(context).inflate(com.teleop_drone.org.R.layout.controller_stick, this, true);
        divet = (ImageView) findViewById(R.id.controller_button);
    }
    public ControllerStick(Context context){
        super(context);
        initControllerStick(context);
    }
    public ControllerStick(Context context, AttributeSet attrs){
        super(context, attrs);
        initControllerStick(context);
    }
    public ControllerStick(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initControllerStick(context);
    }
    @Override
    public void onAnimationEnd(Animation animation) {

    }
    @Override
    public void onAnimationRepeat(Animation animation){

    }
    @Override
    public void onAnimationStart(Animation animation){

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        final int action = event.getAction();
        Log.d("TouchEvent", "x:" + event.getX() + ",y:" + event.getY());
        divet.setTranslationX(event.getX());
        divet.setTranslationY(event.getY());
        divet.setAlpha(1.0f);
          //  }
        //}
        return true;
    }

    /*ROS functions*/
    @Override
    public GraphName getDefaultNodeName() {
        return GraphName.of("teleop_drone/controller_stick");
    }

    @Override
    public void onStart(ConnectedNode connectedNode) {
    }
    @Override
    public void onShutdown(Node node){
    }
    @Override
    public void onShutdownComplete(Node node){

    }
    @Override
    public void onError(Node node, Throwable throwable){

    }

}
