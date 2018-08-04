package ptidej.sad.smelldetectioncaller.adapter;
 
public class SmellAdapterFactory {

	

	public static DesignSmellAdapter getAdapter(String antiPatternName) {

		switch (antiPatternName) {

		case DesignSmellAdapter.ANTISINGLETON:
			return new AntisingletonAdapter();
		case DesignSmellAdapter.BLOB:
			return new BlobAdapter();
		case DesignSmellAdapter.SWISS_ARMY_KNIFE:
			return new SwissArmyKnifeAdapter();

		}

		return null;

	}

}
