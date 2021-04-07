/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mlriskscorelm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.kie.pmml.models.regression.model.KiePMMLRegressionTable;

public class KiePMMLRegressionTableRegression1 extends KiePMMLRegressionTable {

    public KiePMMLRegressionTableRegression1() {
        intercept = 0.728738020314142;
        targetField = "Risk";
        numericFunctionMap.put("MonthlySalary", this::evaluateNumericPredictor2);
        numericFunctionMap.put("TotalRequired", this::evaluateNumericPredictor3);
        numericFunctionMap.put("NumberInstallments", this::evaluateNumericPredictor4);
        numericFunctionMap.put("Age", this::evaluateNumericPredictor1);
    }

    @Override
    public Object getTargetCategory() {
        return null;
    }

    @Override
    protected void updateResult(final AtomicReference<Double> toUpdate) {
    }

    @Override
    protected void populateOutputFieldsMapWithResult(final Object result) {
        outputFieldsMap.put("Predicted_Risk", result);
    }

    private double evaluateNumericPredictor1(double input) {
        double coefficient = 0.00337820896303838;
        // Ignoring exponent because it is 1
        return input * coefficient;
    }

    private double evaluateNumericPredictor2(double input) {
        double coefficient = -1.1880868132675E-5;
        // Ignoring exponent because it is 1
        return input * coefficient;
    }

    private double evaluateNumericPredictor3(double input) {
        double coefficient = 3.05301966698015E-7;
        // Ignoring exponent because it is 1
        return input * coefficient;
    }

    private double evaluateNumericPredictor4(double input) {
        double coefficient = -4.90511511109188E-4;
        // Ignoring exponent because it is 1
        return input * coefficient;
    }
}
