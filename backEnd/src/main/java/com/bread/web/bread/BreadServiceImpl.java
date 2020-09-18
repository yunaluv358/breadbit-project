package com.bread.web.bread;

import com.bread.web.utils.GenericService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

interface BreadService extends GenericService<Bread> {
    void readCsv();
}
@Service @AllArgsConstructor
public class BreadServiceImpl implements BreadService {
private final BreadRepository breadRepository;
    @Override
    public void save(Bread bread) {
        breadRepository.save(bread);
    }

    @Override
    public Optional<Bread> findById(Long id) {
        return breadRepository.findById(id);
    }

    @Override
    public Iterable<Bread> findAll() {
        return breadRepository.findAll();
    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }


    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/bread.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                breadRepository.save(new Bread(
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6),
                        csvRecord.get(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
