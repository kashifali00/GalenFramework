package galen_tests;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.setup.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GeneralLayOutTest extends BaseTest

{
    @Test
    public void validHomeLogo() throws IOException {
        String home_spec = getSpecFilePath() + File.separator + "home.gspec";
        LayoutReport objLayoutReport =
                Galen.checkLayout(getDriver(), home_spec, Arrays.asList("desktop_HomeLogo"));

        List<GalenTestInfo> objGalentestsList	= new LinkedList<GalenTestInfo>();
        //Create a GalenTestInfo object
        GalenTestInfo objSingleGalenTest 		= GalenTestInfo.fromString("Home Logo main title here");
        //Get layoutReport and assign to test object
        objSingleGalenTest.getReport().layout(objLayoutReport, "Home LOGO single test title here");
        //Add test object to the tests list
        objGalentestsList.add(objSingleGalenTest);
        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        //Create a report under specified folder based on tests list
        htmlReportBuilder.build(objGalentestsList, "ReportFolder_Home_Logo");
        //If layoutReport has errors Assert Fail
        if (objLayoutReport.errors() > 0)
        {
            System.out.println("Layout test failed for HomeLogo");
            Assert.fail();
        }
        System.out.println("Layout test PASSED for HomeLogo");
    }
}
