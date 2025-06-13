# $dev_path like /dev/sdb
# $partition_type_code?: like 8e00 for Linux LVM
disk/partition() {
    declare -r disk_dev_path="$1"
    if [[ $# -gt 1 ]]; then
        declare -r second_partition_type_code="$2"
    else
        declare -r second_partition_type_code='8300' # Linux filesystem
    fi
    (
        # https://wiki.archlinux.org/title/EFI_system_partition
        echo o       # Create new partition table
        echo Y       # Confirm

        # Create EFI partition
        echo n       # Create first partition
        echo         # Accept default partition number
        echo         # Accept default first sector
        echo "+2G"   # Partition size
        echo ef00    # Partition type is `ESP/EFI System Partition`

        # Create second partition
        echo n       # Create second partition
        echo         # Accept default partition number
        echo         # Accept default first sector
        echo         # Accept default last sector (all free space)
        echo "$second_partition_type_code"

        echo w       # Write GPT table to disk and exit
        echo Y       # Confirm
    ) | gdisk "$disk_dev_path"
    partprobe || true
    lsblk
}

disk/names() {
    lsblk --noheadings --nodeps --output NAME
}