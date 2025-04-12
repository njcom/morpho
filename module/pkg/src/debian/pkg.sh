updatePkgDb() {
    if [[ $hasAptitude -eq 1 ]]; then
        sudo aptitude update
    else
        sudo apt-get update
    fi
}

uninstallPkg() {
    if [[ $hasAptitude -eq 1 ]]; then
        sudo aptitude purge "$@"
    else
        sudo apt-get purge "$@"
    fi
}

reinstallPkg() {
    sudo apt-get install --reinstall -o Dpkg::Options::='--force-confask,confnew,confmiss' "$@"
}

installPkgFromFile() {
    dpkg -i "$@"
}

# $pkgName
filesInInstalledPkg() {
    dpkg -L "$@"
}

# $pkgName
fileInNotInstalledPkg() {
    sudo apt-file update
    apt-file list "$@"
}

# $filePath
pkgByFile() {
    dpkg -S "$(which "$@")"
}
