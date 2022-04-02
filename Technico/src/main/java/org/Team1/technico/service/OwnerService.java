package org.Team1.technico.service;

import org.Team1.technico.model.Owner;
import org.Team1.technico.model.Property;
import org.Team1.technico.utils.ResponseResult;

import java.util.List;

public interface OwnerService {
    /**
     * @param owner
     * @return ResponseResult<Owner>
     */
    ResponseResult<Owner> createOwner(Owner owner);

    /**
     * @return ResponseResult<List < Owner>>
     */
    ResponseResult<List<Owner>> readOwner();

    /**
     * @param ownerId
     * @return ResponseResult<Owner>
     */
    ResponseResult<Owner> readOwner(int ownerId);

    /**
     * @param vatNumber
     * @param email
     * @return ResponseResult<List < Owner>>
     */
    ResponseResult<List<Owner>> getOwnerByVatNumberOrEmail(String vatNumber, String email);

    /**
     * @param ownerId
     * @param owner
     * @return ResponseResult<Owner>
     */
    ResponseResult<Owner> updateOwner(int ownerId, Owner owner);

    /**
     * @param ownerId
     * @return ResponseResult<Boolean>
     */
    ResponseResult<Boolean> deleteOwner(int ownerId);

    /**
     * @param ownerId
     * @return ResponseResult<List < Property>>
     */
    ResponseResult<List<Property>> getPropertiesOfOwner(int ownerId);
}
