package Com.Config;

import java.sql.Connection;

public class DbConnection {
    MyConfig Con = new MyConfig();
    Connection MyConfig = Con.getConnect();
}
