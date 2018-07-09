/**
 * 项目名称：quickstart-junit 
 * 文件名：AssumptionsTest.java
 * 版本信息：
 * 日期：2018年3月28日
 * Copyright asiainfo Corporation 2018
 * 版权所有 *
 */
package org.quickstart.junit.junit5;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * AssumptionsTest
 * 
 * @author：yangzl@asiainfo.com
 * @2018年3月28日 下午5:31:27
 * @since 1.0
 */
@DisplayName("Assumptions")
public class AssumptionsTest {
    private final String environment = "DEV";

    @Test
    @DisplayName("simple")
    public void simpleAssume() {
        assumeTrue(Objects.equals(this.environment, "DEV"));
        assumeFalse(() -> Objects.equals(this.environment, "PROD"));
    }

    @Test
    @DisplayName("assume then do")
    public void assumeThenDo() {
        assumingThat(Objects.equals(this.environment, "DEV"), () -> System.out.println("In DEV"));
    }
}
