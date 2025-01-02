class NetworkCallback(private val context: Context) {
    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            // İnternet bağlandığında
            Toast.makeText(context, "İnternet bağlantısı kuruldu", Toast.LENGTH_SHORT).show()
        }

        override fun onLost(network: Network) {
            // İnternet bağlantısı kesildiğinde
            Toast.makeText(context, "İnternet bağlantısı kesildi", Toast.LENGTH_SHORT).show()
        }
    }

    fun register() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        }
    }

    fun unregister() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
} 