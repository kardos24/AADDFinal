import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import modelo.Categoria;
import modelo.VideojuegoItem;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import controlador.Controlador;

public class ProgramaImportacionDatos {

	private final static String DIREC_FILE = "files/";
	private final static String NAME_FILE1 = "juegos_0_201.csv";
	private final static String NAME_FILE2 = "juegos_202_400.csv";

	private static Map<String, Categoria> categoriaMap = new HashMap<>();

	public static void main(String[] args) {
		iniciarCategoriaMap();
		loadFile(NAME_FILE1);
		loadFile(NAME_FILE2);
		System.out.println("Se_fini");
	}

	private static void loadFile(String nameFile2) {
		Iterable<CSVRecord> records;
		try {
			Reader in = new InputStreamReader(new FileInputStream(DIREC_FILE
					+ NAME_FILE1), "UTF-8");
			records = CSVFormat.RFC4180.parse(in);
			int row = 0;
			for (CSVRecord record : records) {
//				System.out.println("[Row" + row + "]");
				VideojuegoItem juego = new VideojuegoItem();
				// la primera fila contiene el nombre de las columnas del csv
				for (int i = 1; i < record.size(); i++) {
					String column = record.get(i);
//					System.out.print("[Column" + i + "=" + column + "]");
					rellenarParametro(juego, i, column.trim());
				}
				Controlador.getInstance().registrarJuego(juego);
//				System.out.println();
				row++;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}

	}

	private static void iniciarCategoriaMap() {
		List<Categoria> categoriasList = Controlador.getInstance()
				.recuperarCategorias();
		categoriaMap = categoriasList.stream().collect(
				Collectors.toMap(cat -> cat.getNombre(), cat -> cat));
	}

	private static void rellenarParametro(VideojuegoItem juego, int i,
			String column) {
		switch (i) {
		case 4:
			juego.setNombre(column);
			break;
		case 7:
			juego.setGeneroPrincipal(column);
			break;
		case 9:
			juego.setGeneroSecundario(column);
			break;
		case 11:
			juego.setGeneroOtros(column);
			break;
		case 14:
			juego.setDescripcion(column);
			break;
		case 6:
			juego.setNota(column);
			break;
		case 13:
			juego.setFechaLanzamiento(getFecha(column));
			break;
		case 1:
			juego.setUrlFoto(column);
			break;
		case 3:
			juego.setUrlFicha(column);
			break;
		case 15:
			juego.setPlataformas(getPlataformas(column));
			break;
		}
	}

	private static List<Categoria> getPlataformas(String column) {
		List<Categoria> categorias = new LinkedList<>();
		Arrays.asList(column.split(";"))
				.stream()
				.map(String::trim)
				.forEach(
						(platf) -> {
							Categoria cat = categoriaMap.get(platf);
							if (cat == null) {
								cat = Controlador.getInstance()
										.registrarCategoria(platf);
								categoriaMap.put(platf, cat);
							}
							categorias.add(cat);
						});
		return categorias;
	}

	private static Date getFecha(String column) {
		String fecha = column.replace("de", "").trim(); // 11 de octubre de 2002
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMMMMMMMMM yyyy"); // 11
																				// octubre
																				// 2002
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			return new Date();
		}
	}
}
