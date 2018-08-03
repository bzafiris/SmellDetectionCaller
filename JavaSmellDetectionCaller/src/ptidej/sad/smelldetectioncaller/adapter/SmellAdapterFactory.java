package ptidej.sad.smelldetectioncaller.adapter;

public class SmellAdapterFactory {

	

	public static DesignSmellAdapter getAdapter(String antiPatternName) {

		switch (antiPatternName) {

		case DesignSmellAdapter.ANTISINGLETON:
			return new AntisingletonAdapter();
			

		}

		return null;

	}

}
