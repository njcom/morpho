# $filePath: Path
pkgByFile() {
    rpm -q --whatprovides "$@"
}
