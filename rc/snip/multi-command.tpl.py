#!/usr/bin/env python
from enum import IntEnum
from pathlib import Path

import click
import typer
from pydantic_settings import BaseSettings, SettingsConfigDict
from typer.core import TyperGroup

_SCRIPT_DIR_PATH = Path(__file__).resolve().parent


class _Settings(BaseSettings):
    # extra="$extra", where $extra is one of "ignore": drops undeclared keys (the pydantic default); "allow": attach them; "forbid": raise the exception
    # env_prefix="MY_" means every field reads from MY_<FIELD_NAME>: example_var ← MY_EXAMPLE_VAR.
    model_config = SettingsConfigDict(env_file=_SCRIPT_DIR_PATH / ".env", env_prefix="MY_", extra="ignore")
    example_var: str = "default-value"


class _ExitCode(IntEnum):
    SUCCESS = 0
    USAGE_ERROR = 2
    RUNTIME_ERROR = 1


class _OrderedGroup(TyperGroup):
    def list_commands(self, _context: click.Context) -> list[str]:
        return list(self.commands.keys())


app = typer.Typer(
    cls=_OrderedGroup,
    add_completion=False,
    rich_markup_mode="rich",
    context_settings={"help_option_names": ["-h", "--help"]},
)


@app.callback(invoke_without_command=True)
def _setup() -> None:
    _Settings()
    context = click.get_current_context()
    if context.invoked_subcommand is None:
        typer.echo(context.get_help())
        raise typer.Exit(_ExitCode.USAGE_ERROR)


@app.command()
def first_command() -> None:
    pass


@app.command()
def second_command() -> None:
    settings = _Settings()
    typer.echo(f"example_var = {settings.example_var}")


if __name__ == "__main__":
    app()
