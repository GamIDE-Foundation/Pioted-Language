package robok.trindade.methods.view;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.util.*;

import com.google.android.material.dialog.*;

public class ViewMethods {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;
    private RobokTerminal robokTerminal;
    private TextUtil textUtil;
    	
    public ViewMethods (Context context) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
        textUtil = new TextUtil(context);
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
          robokTerminal.openTerminal();
       }
    }
    
    public void createButton (String text, String bgColor) {
        var txt = textUtil.formatSpaces(text);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        Button robokButton = new Button(robokContext);
        robokButton.setLayoutParams(buttonParams);
        robokButton.setText(textUtil.formatWordWrap(txt));
        robokButton.setBackgroundColor(Color.parseColor(bgColor)); 
        robokTerminal.addToTerminal(robokButton); 
        onExecute(1);
    }

    public void createText (String text, String txtColor) {
        var txt = textUtil.formatSpaces(text);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        TextView robokText = new TextView(robokContext);
        robokText.setLayoutParams(textParams);
        robokText.setText(textUtil.formatWordWrap(txt));
        robokText.setTextColor(Color.parseColor(txtColor));
        robokTerminal.addToTerminal(robokText);
        onExecute(1);
    }
}