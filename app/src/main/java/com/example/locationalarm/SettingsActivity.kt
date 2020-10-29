package com.example.locationalarm

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        findViewById<EditText>(R.id.latText)
        val sharedPref =
            this?.getSharedPreferences(getString(R.string.PREFS_NAME), Context.MODE_PRIVATE)
                ?: return
        with(sharedPref.edit()) {
            putString("userLat", findViewById<EditText>(R.id.latText)?.text.toString())
            putString("userLang", findViewById<EditText>(R.id.langText)?.text.toString())
            commit()

        }
    }
    fun onClickButton(view: View) {
        val sharedPref =
            this?.getSharedPreferences(getString(R.string.PREFS_NAME),
                Context.MODE_PRIVATE) ?: return
        AlarmLat =
            java.lang.Double.parseDouble(sharedPref.getString("userLat",
                "13.07975"))
        AlarmLong =
            java.lang.Double.parseDouble(sharedPref.getString("userLang",
                "80.1798347"))
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_LONG).show()
    }
}