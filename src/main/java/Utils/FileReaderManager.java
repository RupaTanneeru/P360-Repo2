package Utils;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager =  new  FileReaderManager();
	private ConfigFileReader configFileReader;
	
	public static FileReaderManager getInstance()
	{
		return fileReaderManager;
	}
	public ConfigFileReader getConfigReader()
	{
		return(configFileReader==null)? new ConfigFileReader() :configFileReader;
	}
}
