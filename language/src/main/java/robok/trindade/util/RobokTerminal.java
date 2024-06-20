package robok.trindade.util;

import android.content.*;
import android.view.*;
import android.widget.*;

import com.google.android.material.bottomsheet.*;

import robok.trindade.R;

public class RobokTerminal extends BottomSheetDialog {

    private LinearLayout terminal;
    private View bottomSheetView;
    
    public RobokTerminal (Context context) {
        super(context);
        
        bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialog_terminal, null);
        setContentView(bottomSheetView);
        
        setCancelable(true);
        terminal = bottomSheetView.findViewById(R.id.background_terminal);
    }
    
    
    public void addToTerminal(View view) {
        terminal.addView(view);
    }
}