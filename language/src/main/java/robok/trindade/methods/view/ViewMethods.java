package robok.trindade.methods.view;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

import robok.trindade.R; 
import robok.trindade.utils.*;

import com.google.android.material.dialog.*;

public class ViewMethods extends Terminal {

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	private static final int WRAP_CONTENT= LinearLayout.LayoutParams.WRAP_CONTENT;
	
    private Context robokContext;    
    	
    private RobokTerminal robokTerminal;
    	
    public ViewMethods (Context context) {
        robokContext = context;
        robokTerminal = new RobokTerminal(context);
    }
    
    public void onExecute (int typeCode) {
       if (typeCode == 1) {
          robokTerminal.openTerminal();
       }
    }
    
    public void createButton (String text, String bgColor) {
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        Button robokButton = new Button(robokContext);
        robokButton.setLayoutParams(buttonParams);
        robokButton.setText(text);
        robokButton.setBackgroundColor(Color.parseColor(bgColor)); 
        addToTerminal(robokButton); 
        onExecute(1);
    }

    public void createText (String textVal, String txtColor) {
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
        TextView robotText = new TextView(robokContext);
        robokText.setLayoutParams(textParams);
        robokText.setText(textVal);
        robokText.setTextColor(Color.parseColor(txtColor));
        addToTerminal(robotText);
        onExecute(1);
    }
}