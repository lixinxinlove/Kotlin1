##### 标题
` private fun registSreenStatusReceiver() {
         mScreenStatusReceiver = LocalBroadcastReceiver()
         val screenStatusIF = IntentFilter()
         screenStatusIF.addAction(Intent.ACTION_SCREEN_ON)
         screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF)
         registerReceiver(mScreenStatusReceiver, screenStatusIF)
     }`