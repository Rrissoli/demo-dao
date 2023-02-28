	Connection conn = src.db.DB.getConnection();
		
		src.db.DB.closeConnection();
		// vamos fazer uma demonstração para recuperar dados
		// ResultSet
		// first() [move para a primeria posicão1 , se houver ]
		// beforeFirst() [move para posição 0]
		// next() [move para o próximo, retorna false se ja estiver no ultimo]
		// absolute(int) [move para a posição dada, lembrando que dados reais começam em 1]
		private static Connection conn = null;
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
				
			} catch (Exception e) {
				throw new DbException(e.getMessage());
			}
			
		}
		return conn;
	}
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	
	
	private static final long serialVersionUID = 1L;
	public DbException(String msg) {
		super(msg);
	}