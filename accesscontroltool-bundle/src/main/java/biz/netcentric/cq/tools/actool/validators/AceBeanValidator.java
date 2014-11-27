package biz.netcentric.cq.tools.actool.validators;

import java.util.Set;

import biz.netcentric.cq.tools.actool.helper.AceBean;
import biz.netcentric.cq.tools.actool.validators.exceptions.AcConfigBeanValidationException;
import biz.netcentric.cq.tools.actool.validators.exceptions.AlreadyDefinedGroupException;
import biz.netcentric.cq.tools.actool.validators.exceptions.DoubledDefinedActionException;
import biz.netcentric.cq.tools.actool.validators.exceptions.DoubledDefinedJcrPrivilegeException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidActionException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidGroupNameException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidJcrPrivilegeException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidPermissionException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidRepGlobException;
import biz.netcentric.cq.tools.actool.validators.exceptions.NoActionOrPrivilegeDefinedException;
import biz.netcentric.cq.tools.actool.validators.exceptions.InvalidPathException;
import biz.netcentric.cq.tools.actool.validators.exceptions.NoGroupDefinedException;
import biz.netcentric.cq.tools.actool.validators.exceptions.TooManyActionsException;

public interface AceBeanValidator {

    boolean validate(final AceBean aceBean)
            throws AcConfigBeanValidationException;

    boolean validateGlobbing(AceBean tmpAclBean) throws InvalidRepGlobException;

    boolean validatePermission(AceBean tmpAclBean)
            throws InvalidPermissionException;

    boolean validatePrivileges(AceBean tmpAclBean)
            throws NoActionOrPrivilegeDefinedException,
            InvalidJcrPrivilegeException, DoubledDefinedJcrPrivilegeException;

    boolean validateActions(AceBean tmpAclBean) throws InvalidActionException,
            TooManyActionsException, DoubledDefinedActionException;

    boolean validateAcePath(AceBean tmpAclBean) throws InvalidPathException;

    boolean validateAuthorizableId(Set<String> groupsFromCurrentConfig,
            AceBean tmpAclBean) throws NoGroupDefinedException,
            InvalidGroupNameException;

    public void setBean(AceBean aceBean);

    public void setGroupsFromCurrentConfig(Set<String> groupsFromCurrentConfig);

    public void setBeanCounter(long value);

    public void setCurrentAuthorizableName(final String name)
            throws AlreadyDefinedGroupException;

    public void enable();

    public void disable();

}