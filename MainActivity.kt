class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // active JavascriptInterface 
        webview.settings.javaScriptEnabled = true
        

        // add JavascriptInterface - ex) name : "Android"
        webview.addJavascriptInterface(WebAppInterface(this), "Android")

        webview.loadUrl("file:///android_asset/sample.html")
    }

    /** Instantiate the interface and set the context  */
    class WebAppInterface(private val mContext: Context) {

        /** Show a toast from the web page  */
        @JavascriptInterface
        fun function(value : String) {
            // dosomething....
        }
    }
}

/** 
  If you want use function : 
  
  ex)
  
    <script type="text/javascript">
      function callAndroidFunction(value) {
          Android.function(value);
      }
    </script>
    
*/
