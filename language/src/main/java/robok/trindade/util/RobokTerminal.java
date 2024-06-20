package robok.trindade.utils;

import android.content.*;
import android.view.*;
import android.widget.*;

import com.google.android.material.bottomsheet.*;

public class RobokTerminal {

    private LinearLayout terminal;
    private BottomSheetDialog terminalSheet;
	private View bottomSheetView;
	
	private Context robokContext;    
    	
    public RobokTerminal (Context context) {
        robokContext = context;
        
		initializeBottomSheet();
		
        terminalSheet.setCancelable(true);
        terminal = bottomSheetView.findViewById(R.irobokDialog.terminal);
    }
	
	public void initializeBottomSheet () {
        bottomSheetView = LayoutInflater.from(robokContext).inflate(R.layout.terminal, null);
		terminalSheet = new BottomSheetDialog(robokContext);
		terminalSheet.setContentView(bottomSheetView);
    }
    
    public void addToTerminal (View view){
        terminal.addView(view);
    }
    
    public void openTerminal (){
        terminalSheet.show();
    }
     
}