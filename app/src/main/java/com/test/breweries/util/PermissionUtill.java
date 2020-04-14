package com.test.breweries.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.test.breweries.common.AppConstants;

public class PermissionUtill
{
    public static boolean isPermissionsRequest(Context context, final String... permissions)
    {
        for (String perm : permissions) {
            return ContextCompat.checkSelfPermission(context, perm) == PackageManager.PERMISSION_GRANTED;
        }
        return false;
    }

    public static void requestPermissions(Activity context, final String... permissions) {
        ActivityCompat.requestPermissions(context,
                permissions, AppConstants.REQUEST_CODE);
    }
}
