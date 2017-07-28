package Builders;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ash on 7/28/2017.
 */
public class UsersSave {
    public void writeToFile(List<UserBuilder> users) throws IOException {
         File dir = new File("C:\\temp");
        dir.mkdirs();
        File f = new File(dir, "users");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(users);
        oos.flush();
        oos.close();
    }

    public List<UserBuilder> readFromFile(String fileName) throws IOException, ClassNotFoundException {
        List<UserBuilder> users;
        File f = new File("C:\\temp", fileName);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f.getAbsoluteFile()));
        Object obj = ois.readObject();
        System.out.println("Loaded neuralnet from file: " + f.getPath());
        users = (ArrayList<UserBuilder>) obj;
        ois.close();
        return users;
    }

}
