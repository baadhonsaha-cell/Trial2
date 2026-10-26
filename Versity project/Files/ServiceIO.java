
package Files;

import Entity.Service;
import EntityList.ServiceList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ServiceIO {
    public static void writeServiceIO(Service service) {
        try {
            File file = new File("./Files/Data/Service.txt");
            FileWriter fw = new FileWriter(file, true);

            String s = service.getDoctorName() + "~" +
                       service.getPatientId() + "~" +
                       service.getPatientName() + "~" +
                       service.getAge() + "~" +
                       service.getWeight() + "~" +
                       service.getSex() + "~" +
                       service.getServiceName() + "~" +
                       service.getCost() + "~" +
                       service.getServiceType() + "\n";

            fw.write(s);
            fw.flush();
            fw.close();
            System.out.println("Service saved successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing Service: " + e);
        }
    }

    public static void readServiceIO(ServiceList serviceList) {
        try {
            File file = new File("./Files/Data/Service.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split("~");

                if (data.length == 9) {
                    Service service = new Service(
                        data[0],
                        data[1],
                        data[2],
                        Float.parseFloat(data[3]),
                        Float.parseFloat(data[4]),
                        data[5],
                        data[6],
                        Float.parseFloat(data[7]),
                        data[8]
                    );
                    serviceList.insert(service);
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error while reading Service: " + e);
        }
    }
    public static void updateServiceIO (ServiceList serviceList) {
    try {
        File file = new File("./Files/Data/Service.txt");
        FileWriter fw = new FileWriter(file, false); 

        for (int i = 0; i < serviceList.getSize(); i++) {
            Service s = serviceList.get(i);
            if (s != null) {
                fw.write(s.getServiceDetails()+"\n");
            }
        }

        fw.flush();
        fw.close();
        System.out.println("Service Updated successfully!");
    } catch (IOException e) {
        System.out.println("Error while saving services: " + e);
    }
}

}

