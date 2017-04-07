package id.sch.smktelkom_mlg.project2.xirpl608202231.mocha;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Dafa Zakhulhaq on 07/04/2017.
 */

public class PrefManager {

    private static final String PREF_NAME = "androidhive-welcome";
    private static final String IS_FRIST_TIME_LAUNCH = "IsFristTimeLaunch";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    public PrefManager(Context context) {
        this._context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public boolean isFirstTimeLaunch() {

        return pref.getBoolean(IS_FRIST_TIME_LAUNCH, true);

    }

    public void setIsFristTimeLaunch(boolean isFristTime) {
        editor.putBoolean(IS_FRIST_TIME_LAUNCH, isFristTime);
        editor.commit();

    }

}
