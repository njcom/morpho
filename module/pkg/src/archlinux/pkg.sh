updatePkgDb() {
    # Alternatives: yay -Fy
    sudo pacman -Syy
}

updatePkgs() {
    #updateAurPkgs
    if [[ $# -gt 0 ]]; then
        sudo pacman -Syy
        sudo pacman -S "$@"
    else
        # Update keyring first to avoid problems with GPG keys of packages:
        sudo pacman -Sy archlinux-keyring
        sudo pacman -Syyu
    fi
}

installPkg() {
    local paths=()
    local names=()
    for pkgOrPath in "$@"; do
        if [[ -f "$pkgOrPath" ]]; then
            paths+=("$pkgOrPath")
        else
            names+=("$pkgOrPath")
        fi
    done
    if [[ ${#names[@]} -gt 0 ]]; then
        sudo pacman -S --needed "${names[@]}"
    fi
    if [[ ${#paths[@]} -gt 0 ]]; then
       _installPkgFromFile "${paths[@]}"
    fi
}

clearPkgCache() {
    # Removes files from /var/cache/pacman/pkg, see https://wiki.archlinux.org/index.php/Pacman#Cleaning_the_package_cache
    sudo pacman -Scc
}

uninstallPkg() {
    sudo pacman -Rs "$@"
}

uninstallPkgWithoutCheckingDeps() {
    sudo pacman -Rdd "$@"
}

reinstallPkg() {
    sudo pacman -S "$@"
}

################################################################################
# private

_installPkgFromFile() {
    sudo pacman -U "$@"
}

### todo: vvvv
## todo: Package > Pkg



isPackageInstalled() {
    if pacman -Q "$@" &> /dev/null; then
        echo Installed
        return 0
    else
        echo Not installed
        return 1
    fi
}



packageInfo() {
    # yay handles both AUR and not AUR packages.
    yay -Si "$@"
}

orphanedPackages() {
    pacman -Qdt "$@"
}

packages() {
    pacman -Q
     #| awk '{print $1}'
}

filesInPackage() {
    for package in "$@"; do
        if isPackageInstalled $package &> /dev/null; then
            filesInInstalledPackage "$@"
        else
            filesInNotInstalledPackage "$@"
        fi
    done
}

filesInInstalledPackage() {
    pacman -Ql "$@"
}

filesInNotInstalledPackage() {
    sudo pacman -Fy
    yay -Fl "$@"
}

packageDeps() {
    pactree -l "$@"
}

notInstalledPackageByFile() {
    # Options:
    # -r enable regular expression matching
    sudo pacman -Fy
    pacman -F "$@"
    #sudo pkgfile -u
    #pkgfile "$@"
    #pacman -F "$@" # it does not work in bash for some reason, but does work in fish
}

packageByFile() {
    #pacman -F "$@"
    if ! pkgfile "$@"; then
        notInstalledPackageByFile "$@"
    fi
}

findPackage() {
    pacman -Ss "$@"
}

deletePackageCache() {
    sudo pacman -Sc "$@"
}

brokenPackages() {
    echo @TODO
    #pactree -l pacman | sort -u | cut -f 1 -d ' '
}

depsOf() {
    for package in "$@"; do
        pactree  -l "$package" | grep -vP "^${package}$"
    done
}

requiredBy() {
    pactree --reverse "$@"
}

packageSourceUri() {
    local package="$1"
    local repo=
    if [[ $(pacman -Si "$package" | egrep 'Repository\s*' | awk -F':' '{print $2}' | xargs | tr '[:upper:]' '[:lower:]') == "community" ]]; then
        repo=community
    else
        repo=packages
    fi
    cat <(downloadToStdout https://git.archlinux.org/svntogit/${repo}.git/plain/trunk/PKGBUILD\?h\=packages/"$package") <(echo 'echo $source') | bash -
}

packagesInGroup() {
    pacman -Sg "$@"
}



###############################################################################
# AUR

installAurPackage() {
    yay -S "$@"
}

updateAurPackages() {
    if [[ $# -gt 0 ]]; then
        yay -S "$@"
    else
        yay
    fi
}

aurPackages() {
    pacman -Qm
}

# $packageName
aurPackageDownloadUri() {
    echo todo
    #package-query -Aif '%i %w %o %m %u' "$@" | awk '{print $NF}'
}

# $packageName
downloadAurPackageFile() {
    dl $(aurPackageDownloadUri "$@")
}


