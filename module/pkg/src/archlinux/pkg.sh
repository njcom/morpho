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



isPkgInstalled() {
    if pacman -Q "$@" &> /dev/null; then
        echo Installed
        return 0
    else
        echo Not installed
        return 1
    fi
}



pkgInfo() {
    # yay handles both AUR and not AUR packages.
    yay -Si "$@"
}

orphanedPkgs() {
    pacman -Qdt "$@"
}

pkgs() {
    pacman -Q
     #| awk '{print $1}'
}

filesInPkg() {
    for pkg in "$@"; do
        if isPkgInstalled $pkg &> /dev/null; then
            filesInInstalledPkg "$@"
        else
            filesInNotInstalledPkg "$@"
        fi
    done
}

filesInInstalledPkg() {
    pacman -Ql "$@"
}

filesInNotInstalledPkg() {
    sudo pacman -Fy
    yay -Fl "$@"
}

pkgDeps() {
    pactree -l "$@"
}

notInstalledPkgByFile() {
    # Options:
    # -r enable regular expression matching
    sudo pacman -Fy
    pacman -F "$@"
    #sudo pkgfile -u
    #pkgfile "$@"
    #pacman -F "$@" # it does not work in bash for some reason, but does work in fish
}

pkgByFile() {
    #pacman -F "$@"
    if ! pkgfile "$@"; then
        notInstalledPkgByFile "$@"
    fi
}

findPkg() {
    pacman -Ss "$@"
}

deletePkgCache() {
    sudo pacman -Sc "$@"
}

brokenPkgs() {
    echo @TODO
    #pactree -l pacman | sort -u | cut -f 1 -d ' '
}

depsOf() {
    for pkg in "$@"; do
        pactree  -l "$pkg" | grep -vP "^${pkg}$"
    done
}

requiredBy() {
    pactree --reverse "$@"
}

pkgSourceUri() {
    local pkg="$1"
    local repo=
    if [[ $(pacman -Si "$pkg" | egrep 'Repository\s*' | awk -F':' '{print $2}' | xargs | tr '[:upper:]' '[:lower:]') == "community" ]]; then
        repo=community
    else
        repo=pkgs
    fi
    cat <(dlToStdout https://git.archlinux.org/svntogit/${repo}.git/plain/trunk/PKGBUILD\?h\=packages/"$pkg") <(echo 'echo $source') | bash -
}

pkgsInGroup() {
    pacman -Sg "$@"
}

###############################################################################
# AUR

installAurPkg() {
    yay -S "$@"
}

updateAurPkgs() {
    if [[ $# -gt 0 ]]; then
        yay -S "$@"
    else
        yay
    fi
}

aurPkgs() {
    pacman -Qm
}

# $pkgName
aurPkgDlUri() {
    echo todo
    #package-query -Aif '%i %w %o %m %u' "$@" | awk '{print $NF}'
}

# $pkgName
dlAurPkgFile() {
    dl $(aurPkgDlUri "$@")
}


