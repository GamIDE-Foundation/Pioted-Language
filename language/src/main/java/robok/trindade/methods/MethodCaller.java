package robok.trindade.methods;

import android.content.*;
import android.widget.*;
import android.graphics.*;

import robok.trindade.methods.*;
import robok.trindade.util.*;

import java.lang.ref.*;
import java.lang.reflect.*;
import java.util.*;

public class MethodCaller {

    private Map<String, Method> methodsMap;
    private Context context;
    
    private Methods methodsInstance;
    
    public MethodCaller(Context context) {
        methodsMap = new HashMap<>();
        this.context = context;
        methodsInstance = new Methods(context);
        
        try {
            methodsMap.put("showToast", Methods.class.getDeclaredMethod("showToast", String.class));
            methodsMap.put("createButton", Methods.class.getDeclaredMethod("createButton", String.class, String.class));
            methodsMap.put("createText", Methods.class.getDeclaredMethod("createText", String.class, String.class));
            methodsMap.put("openTerminal", Methods.class.getDeclaredMethod("openTerminal"));
			methodsMap.put("showDialog", Methods.class.getDeclaredMethod("showDialog", String.class, String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void callMethod(String methodName,  Object... args) {
        Method method = methodsMap.get(methodName);
        if (method != null) {
            try {
                method.invoke(methodsInstance, args);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Erro ao chamar método '" + methodName + "'.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Método '" + methodName + "' não encontrado.", Toast.LENGTH_SHORT).show();
        }
    }
}
