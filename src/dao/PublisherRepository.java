package dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import domain.Publisher;

public class PublisherRepository extends Repository{
	public List<Publisher> getPublishers() throws SQLException{
		try {
		open();
		stmt = connection.createStatement();
		rs = stmt.executeQuery("SELECT * FROM Publisher");
		List<Publisher> list = new LinkedList<Publisher>();
		while(rs.next()) {
		list.add(new Publisher(rs.getInt("PublisherId"),
		rs.getString("PublisherName")));
		}
		return list;
		}finally {
		close();
		}
		}

}
