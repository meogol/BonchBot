package test;

import core.db.DBCore;
import core.db.data.DBUser;

public class TestDB {
    public static void main(String[] args) {
        DBCore.readFromConfig();
        DBCore dbCore = new DBCore();
        dbCore.dbWrite("insert into Users (vk_user_id, post_tag) values(8, \'text\') ");
        var array = dbCore.dbRead("select * from Users", DBUser.class);
        for (var item: array){
            System.out.println(item.toString() + '\n');
        }
    }
}
