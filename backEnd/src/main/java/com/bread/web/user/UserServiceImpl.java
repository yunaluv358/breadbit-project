package com.bread.web.user;
import com.bread.web.utils.GenericService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

interface UserService extends GenericService<User> {
    void readCsv();
    Map<String,Integer> chartData(String name);
}

@Service @AllArgsConstructor
public class UserServiceImpl implements UserService {
    final private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }

    @Override
    public void readCsv() {
        InputStream is = getClass().getResourceAsStream("/static/user.csv");

        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                userRepository.save(new User(
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        csvRecord.get(4),
                        csvRecord.get(5),
                        csvRecord.get(6),
                        csvRecord.get(7),
                        csvRecord.get(8)
                        ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String,Integer> chartData(String name) {
        Optional<User>  userResult = userRepository.findByName(name);
        Map<String,Integer> mapResult = new TreeMap<>();
        String[] result = userResult.toString()
                .replace("Optional[","").replace("]","")
                .split(",");
        System.out.println(result.toString());
        for(int i=0;i<= 7;i++){
            mapResult.put("2020-0"+(i+1),Integer.parseInt(result[i]));
            System.out.println(mapResult.toString());
        }
        return mapResult;

    }
}