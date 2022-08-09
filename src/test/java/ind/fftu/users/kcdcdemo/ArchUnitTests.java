package ind.fftu.users.kcdcdemo;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@SpringBootTest
public class ArchUnitTests {

//    https://www.archunit.org/userguide/html/000_Index.html

    /**
     * Test to show how archUnit allows us to define "rules"
     * for the project's architecture
     */
    @Test
    void archRuleTest() {
        JavaClasses jc = new ClassFileImporter()
                .importPackages("ind.fftu.users.kcdcdemo");

        ArchRule r1 = classes()
                .that()
                .resideInAPackage("..controller..")
                .should().beAnnotatedWith("@Controller")
//                .as("Annotation Issue/") //commented to show full error
                .because("Controllers need to be properly annotated.");
        r1.check(jc);
    }
}
