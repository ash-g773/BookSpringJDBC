package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

	
@Configuration
@ComponentScan(basePackages = {"presentation", "persistence", "service"})
public class BookClientConfiguration {
		
		@Bean(name="MySqlDataSource")
		public DriverManagerDataSource getDataSource() {
			DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
			driverManagerDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/wileydi001");
			driverManagerDataSource.setUsername("root");
			driverManagerDataSource.setPassword("MySQLRoot123");
			driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			
			return driverManagerDataSource;
			
		}
		
		@Bean
		public JdbcTemplate getTemplate() {
			return new JdbcTemplate(getDataSource());
		}

	
}
