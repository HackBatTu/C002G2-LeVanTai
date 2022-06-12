package reponsitory.impl;

import reponsitory.DBConnect;
import reponsitory.IRepository;

public class Repository implements IRepository {

    private DBConnect dbConnect = new DBConnect();
    private static final String SELECT_ = " select * from where status = 0;";
    private static final String SELECT_ALL = " ";
    private static final String INSERT_ = " ";
    private static final String FIND_BY_ID = " ";
    private static final String DELETE = " ";

}
