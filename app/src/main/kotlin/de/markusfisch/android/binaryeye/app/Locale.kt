package de.markusfisch.android.binaryeye.app

import android.content.Context
import android.os.Build
import java.util.*

fun Context.applyLocale(localeName: String) {
	if (localeName.isNotEmpty()) {
		val locale = Locale(localeName)
		Locale.setDefault(locale)
		val conf = resources.configuration
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
			@Suppress("DEPRECATION")
			conf.locale = locale
		} else {
			conf.setLocale(locale)
		}
		resources.updateConfiguration(conf, resources.displayMetrics)
	}
}
