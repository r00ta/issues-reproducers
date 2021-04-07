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

import java.util.Map;
import org.kie.pmml.models.regression.model.KiePMMLRegressionModel;

public class LmModel extends KiePMMLRegressionModel {

    public LmModel() {
        super("lm_Model");
        regressionTable = new mlriskscorelm.KiePMMLRegressionTableRegression1();
        targetField = "Risk";
        miningFunction = org.kie.pmml.api.enums.MINING_FUNCTION.REGRESSION;
        pmmlMODEL = org.kie.pmml.api.enums.PMML_MODEL.REGRESSION_MODEL;
        miningFields.add(new org.kie.pmml.api.models.MiningField("Risk", org.kie.pmml.api.enums.FIELD_USAGE_TYPE.PREDICTED, null, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, java.util.Arrays.asList(), java.util.Arrays.asList()));
        miningFields.add(new org.kie.pmml.api.models.MiningField("Age", org.kie.pmml.api.enums.FIELD_USAGE_TYPE.ACTIVE, null, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, java.util.Arrays.asList(), java.util.Arrays.asList()));
        miningFields.add(new org.kie.pmml.api.models.MiningField("MonthlySalary", org.kie.pmml.api.enums.FIELD_USAGE_TYPE.ACTIVE, null, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, java.util.Arrays.asList(), java.util.Arrays.asList()));
        miningFields.add(new org.kie.pmml.api.models.MiningField("TotalRequired", org.kie.pmml.api.enums.FIELD_USAGE_TYPE.ACTIVE, null, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, java.util.Arrays.asList(), java.util.Arrays.asList()));
        miningFields.add(new org.kie.pmml.api.models.MiningField("NumberInstallments", org.kie.pmml.api.enums.FIELD_USAGE_TYPE.ACTIVE, null, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, java.util.Arrays.asList(), java.util.Arrays.asList()));
        outputFields.add(new org.kie.pmml.api.models.OutputField("Predicted_Risk", org.kie.pmml.api.enums.OP_TYPE.CONTINUOUS, org.kie.pmml.api.enums.DATA_TYPE.DOUBLE, null, org.kie.pmml.api.enums.RESULT_FEATURE.PREDICTED_VALUE, null));
    }
}
