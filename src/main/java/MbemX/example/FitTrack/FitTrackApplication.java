package MbemX.example.FitTrack;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableCaching
@SpringBootApplication
public class FitTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitTrackApplication.class, args);
	}

}
