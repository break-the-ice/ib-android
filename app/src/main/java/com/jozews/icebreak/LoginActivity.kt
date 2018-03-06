
package com.jozews.icebreak

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.beust.klaxon.JsonObject

import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

import java.net.URL
import java.net.HttpURLConnection

import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedReader
import  java.io.UnsupportedEncodingException

import com.github.kittinunf.fuel.*
import com.github.kittinunf.result.*

import com.beust.klaxon.Parser
import com.beust.klaxon.Klaxon

import org.json.JSONObject
import java.nio.charset.Charset

class LoginActivity : AppCompatActivity() {

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(
                callbackManager!!,
                object : FacebookCallback<LoginResult> {

                    override fun onSuccess(result: LoginResult) {

                    }

                    override fun onCancel() {
                        //TODO Auto-generated method stub
                        println("=========================onCancel")
                    }

                    override fun onError(error: FacebookException) {
                        //TODO Auto-generated method stub
                        println("=========================onError" + error.toString())
                    }
                }
        )

        val button: Button = findViewById(R.id.facebook_button)
        button.setOnClickListener({
            LoginManager.getInstance().logInWithReadPermissions(this@LoginActivity, listOf("public_profile"))
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
    }
}
