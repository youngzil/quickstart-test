/**
 * 项目名称：quickstart-mock 
 * 文件名：JacocoExecAnalysisTest.java
 * 版本信息：
 * 日期：2017年11月22日
 * Copyright yangzl Corporation 2017
 * 版权所有 *
 */
package org.quickstart.mock.jacoco;

import java.io.File;
import java.io.FileInputStream;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.analysis.IBundleCoverage;
import org.jacoco.core.data.ExecutionDataReader;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.report.DirectorySourceFileLocator;
import org.jacoco.report.FileMultiReportOutput;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.html.HTMLFormatter;

/**
 * JacocoExecAnalysisTest
 * 
 * @author：youngzil@163.com
 * @2017年11月22日 下午10:43:44
 * @since 1.0
 */
public class JacocoExecAnalysisTest {

    public void createReport() throws Exception {
        // 读取监控结果
        final FileInputStream fis = new FileInputStream(new File("jacoco.exec"));
        final ExecutionDataReader executionDataReader = new ExecutionDataReader(fis);
        // 执行数据信息
        ExecutionDataStore executionDataStore = new ExecutionDataStore();
        // 会话信息
        SessionInfoStore sessionInfoStore = new SessionInfoStore();

        executionDataReader.setExecutionDataVisitor(executionDataStore);
        executionDataReader.setSessionInfoVisitor(sessionInfoStore);

        while (executionDataReader.read()) {
        }

        fis.close();

        // 分析结构
        final CoverageBuilder coverageBuilder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(executionDataStore, coverageBuilder);

        // 传入监控时的Class文件目录，注意必须与监控时的一样
        File classesDirectory = new File("classes");
        analyzer.analyzeAll(classesDirectory);

        IBundleCoverage bundleCoverage = coverageBuilder.getBundle("Title");
        // 输出报告
        File reportDirectory = new File("report"); // 报告所在的目录
        final HTMLFormatter htmlFormatter = new HTMLFormatter(); // HTML格式
        final IReportVisitor visitor = htmlFormatter.createVisitor(new FileMultiReportOutput(reportDirectory));
        // 必须先调用visitInfo
        visitor.visitInfo(sessionInfoStore.getInfos(), executionDataStore.getContents());
        File sourceDirectory = new File("src"); // 源代码目录
        // 遍历所有的源代码
        // 如果不执行此过程，则在报告中只能看到方法名，但是无法查看具体的覆盖（因为没有源代码页面）
        visitor.visitBundle(bundleCoverage, new DirectorySourceFileLocator(sourceDirectory, "utf-8", 4));
        // 执行完毕
        visitor.visitEnd();
    }

}
