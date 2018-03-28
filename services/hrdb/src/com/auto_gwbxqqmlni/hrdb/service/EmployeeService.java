/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.auto_gwbxqqmlni.hrdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.auto_gwbxqqmlni.hrdb.Employee;
import com.auto_gwbxqqmlni.hrdb.Vacation;

/**
 * Service object for domain model class {@link Employee}.
 */
public interface EmployeeService {

    /**
     * Creates a new Employee. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Employee if any.
     *
     * @param employee Details of the Employee to be created; value cannot be null.
     * @return The newly created Employee.
     */
	Employee create(@Valid Employee employee);


	/**
	 * Returns Employee by given id if exists.
	 *
	 * @param employeeId The id of the Employee to get; value cannot be null.
	 * @return Employee associated with the given employeeId.
     * @throws EntityNotFoundException If no Employee is found.
	 */
	Employee getById(Integer employeeId) throws EntityNotFoundException;

    /**
	 * Find and return the Employee by given id if exists, returns null otherwise.
	 *
	 * @param employeeId The id of the Employee to get; value cannot be null.
	 * @return Employee associated with the given employeeId.
	 */
	Employee findById(Integer employeeId);


	/**
	 * Updates the details of an existing Employee. It replaces all fields of the existing Employee with the given employee.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Employee if any.
     *
	 * @param employee The details of the Employee to be updated; value cannot be null.
	 * @return The updated Employee.
	 * @throws EntityNotFoundException if no Employee is found with given input.
	 */
	Employee update(@Valid Employee employee) throws EntityNotFoundException;

    /**
	 * Deletes an existing Employee with the given id.
	 *
	 * @param employeeId The id of the Employee to be deleted; value cannot be null.
	 * @return The deleted Employee.
	 * @throws EntityNotFoundException if no Employee found with the given id.
	 */
	Employee delete(Integer employeeId) throws EntityNotFoundException;

    /**
	 * Deletes an existing Employee with the given object.
	 *
	 * @param employee The instance of the Employee to be deleted; value cannot be null.
	 */
	void delete(Employee employee);

	/**
	 * Find all Employees matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Employees.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Employee> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Employees matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Employees.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Employee> findAll(String query, Pageable pageable);

    /**
	 * Exports all Employees matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Employees in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Employee.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated employeesForManagerId for given Employee id.
     *
     * @param empId value of empId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Employee instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Employee> findAssociatedEmployeesForManagerId(Integer empId, Pageable pageable);

    /*
     * Returns the associated vacations for given Employee id.
     *
     * @param empId value of empId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated Vacation instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<Vacation> findAssociatedVacations(Integer empId, Pageable pageable);

}

