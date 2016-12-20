import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ProgramaImportacionDatos {
	
	private final static String DIREC_FILE = "files/";
	private final static String NAME_FILE = "juegos_0_201.csv";

	public static void main(String[] args) {
		Iterable<CSVRecord> records;
		try {
			Reader in = new FileReader(DIREC_FILE + NAME_FILE);
			records = CSVFormat.RFC4180.parse(in);
			int row = 0;
			for (CSVRecord record : records) {
				System.out.println("[Row" + row + "]");
				for (int i = 0; i < record.size(); i++) {
					String column = record.get(i);
					System.out.print("[Column" + i + "=" + column + "]");
				}
				System.out.println();
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
