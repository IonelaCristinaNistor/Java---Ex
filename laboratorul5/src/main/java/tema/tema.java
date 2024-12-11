package tema;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class tema {
        public static void scriere(List<placa> placi) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                File file = new File("src/main/resoruces/mibilier.json");
                mapper.writeValue(file, placi);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static List<placa> citire() {
            try {
                File file = new File("src/main/resources/mobilier.json");
                ObjectMapper mapper = new ObjectMapper();
                List<placa> placi = mapper.readValue(file, new TypeReference<List<placa>>() {
                });
                return placi;


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void main(String[] args) {
            List<placa> placi = citire();
            System.out.println(placi);

            for (placa p : placi) {
                System.out.println(p);
            }
        }
    }
