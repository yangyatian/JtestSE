package testUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.yaml.snakeyaml.Yaml;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class DataSourceUtil {

	public static Object[][] readCsv(String file) {
		Object[][] result;

		try (InputStreamReader reader = new InputStreamReader(
				Objects.requireNonNull(DataSourceUtil.class.getClassLoader()
						.getResourceAsStream(file)));
				CSVParser parser = CSVFormat.DEFAULT.parse(reader)) {
			List<CSVRecord> records = parser.getRecords();
			result = new Object[records.size()][];
			for (int i = 0; i < records.size(); i++) {
				CSVRecord record = records.get(i);
				Object[] tmp = new Object[record.size()];
				for (int j = 0; j < record.size(); j++) {
					tmp[j] = record.get(j);
				}
				result[i] = tmp;
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return result;
	}

	public static Object[][] readExcel(String file, String sheetName) {
		Object[][] result;
		if (file.endsWith(".xlsx")) {
			try (XSSFWorkbook workbook = new XSSFWorkbook(
					Objects.requireNonNull(DataSourceUtil.class
							.getClassLoader().getResourceAsStream(file)));) {
				XSSFSheet sheet = workbook.getSheet(sheetName);
				result = readExcel(sheet);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		} else if (file.endsWith(".xls")) {
			try (HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(
					Objects.requireNonNull(DataSourceUtil.class
							.getClassLoader().getResourceAsStream(file))));) {
				HSSFSheet sheet = workbook.getSheet(sheetName);
				result = readExcel(sheet);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		} else {
			throw new IllegalArgumentException("文件类型错误！");
		}
		return result;
	}

	private static Object[][] readExcel(Sheet sheet) {
		Object[][] result = new Object[sheet.getLastRowNum() + 1][];
		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			Row row = sheet.getRow(i);
			Object[] tmp = new Object[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				cell.setCellType(CellType.STRING);
				tmp[j] = cell.getStringCellValue();

			}
			result[i] = tmp;
		}
		return result;
	}

	private static InputStream getStreamFromFile(String file) {
		return Objects.requireNonNull(DataSourceUtil.class.getClassLoader()
				.getResourceAsStream(file));
	}

	public static Map<String, String> readProperties(String file) {
		Map<String, String> result = new HashMap<>();
		Properties properties = new Properties();
		try {
			properties.load(getStreamFromFile(file));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		Iterator<String> iterator = properties.stringPropertyNames().iterator();
		String key;
		while (iterator.hasNext()) {
			key = iterator.next();
			result.put(key, properties.getProperty(key));
		}
		return result;
	}

	public static Map<String, Object> readYaml(String file) {
		Yaml yaml = new Yaml();
		return yaml.load(getStreamFromFile(file));
	}
	
	
	//数据库读取
	public static Object[][] readDatabase(String driver, String url, String username, String password, String sql){
		DatabaseClient databaseClient = new DatabaseClient(driver, url);
		databaseClient.connect(username, password);
		List<LinkedHashMap<String, Object>> tmps = databaseClient.queryData(sql);
		Object[][] result = new Objects[tmps.size()][];
		for(int i = 0; i<=tmps.size(); i++){
			result[i] = tmps.get(i).values().toArray();
		}
		databaseClient.disconnect();
		return result;
	}
}
