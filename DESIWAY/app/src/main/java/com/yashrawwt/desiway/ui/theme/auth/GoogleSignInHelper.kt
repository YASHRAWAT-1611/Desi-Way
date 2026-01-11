package com.yashrawwt.desiway.ui.theme.auth

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

object GoogleSignInHelper {

    fun getClient(context: Context) =
        GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(
                    "418244877192-autnsvua5vfnv9da45nq1epvc34c36d4.apps.googleusercontent.com"
                )
                .requestEmail()
                .build()
        )
}
