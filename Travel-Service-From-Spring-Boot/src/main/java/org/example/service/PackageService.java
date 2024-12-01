package org.example.service;

public interface PackageService {
    Package savePackage(Package aPackage);
    Package getSelectPackage(String package_id);
    void  updatePackage(String package_id, Package aPackage);
    void deletePackage(String package_id);
}
