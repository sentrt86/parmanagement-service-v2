package com.htc.par.data.dao;

import java.util.List;

import com.htc.par.model.ParAllocation;

public interface IParAllocationDAO {
	
	List<ParAllocation> getParAllocationByParNum(String parNum);
	Boolean deleteParAllocationByParAllocId(int parAllocId);

	Boolean createParAllocation(ParAllocation parAllocation);
	Boolean updateCandidateReceived(int parAllocationId,int candidateId,int recruiterId);
	List<ParAllocation> getCandidateReceivedByParNum(String parNum);
	List<ParAllocation> getCandidateReceivedByParCode(int parCode);
	
	Boolean updateSubmitCandidate(ParAllocation parAllocation);
	
	Boolean updatePrescreening(ParAllocation parAllocation);
	
	
	
	

}
