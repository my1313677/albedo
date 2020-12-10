/*
 *  Copyright 2019-2020 somewhere
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.albedo.java.modules.sys.domain.dto;

import com.albedo.java.common.core.annotation.Query;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author somewhere
 * @date 2020-05-10
 */
@Data
public class PersistentTokenQueryCriteria implements Serializable {

	@Query(blurry = "series,tokenValue,username,userAgent,browser,os")
	private String blurry;


	@Query(operator = Query.Operator.between)
	private List<Date> tokenDate;
}
